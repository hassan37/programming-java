package java11_httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class A_SyncRequestExample {

	private static final List<String> URLs = List.of(
		 "http://localhost:3001/cleanup/exp"
		,"https://www.facebook.com/"
		,"https://www.linkedin.com/"
	);
	private static final HttpClient client = HttpClient.newHttpClient(); 

	public static void main(String[] args) throws IOException, InterruptedException {
		httpSyncTest();
		//httpAsyncTest();
	}

	private static void httpSyncTest() throws IOException, InterruptedException {
		HttpRequest req = HttpRequest.newBuilder(URI.create(URLs.get(0))).GET().build();
		var resp = client.send(req, HttpResponse.BodyHandlers.discarding());
		System.out.println("resp > " + resp);
	}

	private static void httpAsyncTest() throws IOException, InterruptedException {
		URLs.stream().map(u -> {
			HttpRequest req = HttpRequest.newBuilder(URI.create(u)).GET().build();

		return client.sendAsync(req, HttpResponse.BodyHandlers.discarding())
			.thenApply(r -> "status: " + r.statusCode())
			.exceptionally(e -> "error: " + e.getMessage());
		}).map(CompletableFuture::join).forEach(System.out::println);
	}
}
