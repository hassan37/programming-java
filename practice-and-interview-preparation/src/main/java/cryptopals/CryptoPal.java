package cryptopals;

import static cryptopals.CryptoPal.FormattingUtil.parseHex;
import static cryptopals.CryptoPal.FormattingUtil.toBase64Str;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HexFormat;

@SuppressWarnings(value = {"WhitespaceAround", "Indentation", "EmptyLineSeparator", "NoWhitespaceBefore", "ParenPad", "MissingJavadocMethod", "LineLength"})
public class CryptoPal {

  public static void main(String[] args) {
    HexToBase64.of().execute();
  }

  //----------------------------------------------------------------------------------------------//

  interface CryptoPalChallenges {
    void execute();
  }

  //---SET 1---CHALLENGE 1---https://cryptopals.com/sets/1/challenges/1---------------------------//

  record HexToBase64() implements CryptoPalChallenges {

    static CryptoPalChallenges of () {
      return new HexToBase64();
    }

    String convertHexToBase64Str(String hex) {
      var bin = parseHex(hex);

      return toBase64Str(bin);
    }

    @Override
    public void execute() {
      var b64Str = convertHexToBase64Str("49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d");
      var passed = b64Str.equals("SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t");
      assert(passed);

      System.out.println(">>> set-1 ch-1: b64Str: " + b64Str + " | passed: " + passed);
    }

  }

  //---UTILS--------------------------------------------------------------------------------------//

  record FormattingUtil() {
    private static final Encoder b64 = Base64.getEncoder();
    private static final HexFormat hexFormat = HexFormat.of();

    static byte[] parseHex(String hex) {
      //1 byte has 2 hex digits. so hex string must be parsed to add 2 hex digits into 1 byte
      //it can be done like: (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character.digit(hexString.charAt(i+1), 16))

      return hexFormat.parseHex(hex);
    }

    static String toBase64Str(byte[] hex) {
      return b64.encodeToString(hex);
    }
  }
}
