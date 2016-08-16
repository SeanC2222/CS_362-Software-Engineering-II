import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase {

//PRIVATE:
   private int numTests = 0;
   private boolean printStatus = false;
   private boolean printIndex = false;

//PROTECTED:
   protected void setUp() {
      //Set up function prior to auto test
   }

   protected void tearDown() {
      //Post test destructors
   }


   // A complete URL is composed of a scheme+authority+port+path+query,
   protected void testIsValidScheme() {

   }

   protected void testIsValidAuthority(){

   }

   protected void testIsValidPort(){

   }

   protected void testIsValidPath(){

   }

   protected void testisValidQuery(){

   }

   protected void hardCodedTests(){
      //All Hardcoded tests wrapped in functions
   }

//PUBLIC:

   public UrlValidatorTest(String testName){
      super(testName);
   }

   public int testIsValid() {
      manualTesting();
      setUp();
   
   }

   public void manualTesting(){
      UrlValidator manTest = new UrlValidator(ALLOW_ALL_SCHEMES);

      boolean valid = manTest.isValid("http://www.facebook.com");
      assert(valid);
      valid = manTest.isValid(".one://falsehose.TLD/");
      assert(!valid);
      valid = manTest.isValid("fake://org.org.org");
      assert(valid);
      valid = manTest.isValid("fake://org.org.org/pathname");
      assert(valid);
      valid = manTest.isValid("fake://org.org.org//pathname");
      assert(!valid);
      valid = manTest.isValid("fake://org.org.org:90/pathname");
      assert(valid);
      valid = manTest.isValid("alFake+still://org.org.org:90");
      assert(valid);
      valid = manTest.isValid("fake://org.org.org:-1");
      assert(!valid);
      valid = manTest.isValid("fake://org.org.org:65535/pathname/subdir.doc");
      assert(valid);
      valid = manTest.isValid("fake://org.org.org:65535/pathname/subdir?key=val");
      assert(valid);
   }


   public static void main(String[] argv){
      UrlValidatorTest myTests = new UrlValidatorTests("manual Tests only");
      myTests.testIsValid();
   }
   //Testing values created using references:
      //Apache: UrlValidatorCorrect/UrlValidatorTest.java
      //IANA: http://www.iana.org/assignments/uri-schemes/uri-schemes.xhtml
      //URL Standard: https://url.spec.whatwg.org/#concept-url-scheme
      //Wikipedia: https://en.wikipedia.org/wiki/Uniform_Resource_Locator/
      //IETF: https://tools.ietf.org/html/rfc3986#section-3.4
   
   ResultPair[] testSchemes =	 {  new ResultPair("http:", true),	//Valid common inet
				    new ResultPair("https:", true),	//Valid common inet
				    new ResultPair("file:", true),	//Valid common local
				    new ResultPair("ftp:", true),	//Valid common inet
				    new ResultPair("data:", true),	//Valid common inet
				    new ResultPair("mailto:", true),	//Valid common inet
				    new ResultPair("h-+.ps:", true),	//Valid, '+', '-', '.' OK 
				    new ResultPair("ABC:", true),	//Valid, capitols OK
				    new ResultPair("", true),		//Valid empty string
				    new ResultPair("https", false),	//Invalid No colon   
				    new ResultPair("http&:", false),	//Invalid, '&' invalid scheme char
				    new ResultPair("123", false),	//Invalid, can't start with num
				    new ResultPair("+http:", false),	//Invalid begin with alpha char
				    new ResultPair("-http:", false),	//Invalid begin with alpha char
				    new ResultPair("a%%%:", false)	//Invalid, '%' not valid
				 };

   ResultPair[] testHosts =	 {  new ResultPair("www.google.com", true),   //Valid host
				    new ResultPair("google.com", true),	      //Valid host
				    new ResultPair("12345.org", true),	      //Valid host
				    new ResultPair("www.12.org", true),	      //Valid host
				    new ResultPair("test.", false),	      //Invalid no TLD
				    new ResultPair(".test", false),	      //Invalid host
				    new ResultPair("test", false),	      //Invalid no TLD
				    new ResultPair("123.012.123.230", true),  //Valid IP
				    new ResultPair("0.0.0.0", true),	      //Valid IP
				    new ResultPair("255.255.255.255", true),  //Valid IP
				    new ResultPair("256.255.255.255", false), //Invalid IP, 256
				    new ResultPair("255.256.255.255", false), //Invalid IP, 256
				    new ResultPair("255.255.256.255", false), //Invalid IP, 256
				    new ResultPair("255.255.255.256", false), //Invalid IP, 256
				    new ResultPair("1.2.3.4.5", false),	      //Invalid too large
				    new ResultPair("123.123.123", false),     //Invalid too small
				    new ResultPair("", false),		      //Invalid No empty host
				    new ResultPair(".123.123.123.123", false) //Invalid start char '.'
			         };

   ResultPair[] testPorts =	 {  new ResultPair("0", true),	     //Valid port (low)
				    new ResultPair("3000", true),    //Valid port (mid)
				    new ResultPair("65535", true),   //Valid port (high)
				    new ResultPair("", true),
				    new ResultPair("-1", false),     //Invalid, non-negative
				    new ResultPair("65536", false),  //Invalid, out of range
				    new ResultPair("ABC", false),    //Invalid, unsigned int
				    new ResultPair(":::", false)     //Invalid, unsigned int
				 };

   ResultPair[] testPaths =	 {  new ResultPair("", true),		      //Valid path-abempty
				    new ResultPair("/", true),		      //Valid path-abempty
				    new ResultPair("/down/the/rabbit/hole", true), //Valid absolute
				    new ResultPair("/document.doc", true),    //Valid rel file path
				    new ResultPair("//", false),	      //Invalid no double '/'
				    new ResultPair("./test", false),	      //Invalid no '.'
				    new ResultPair("../test", false)	      //Invalid no double '.'
				 };

   ResultPair[] testQueries =	 {  new ResultPair("", true),		      //Valid no query
				    new ResultPair("key=val", true),	      //Valid key/val
				    new ResultPair("ke1=va1&ke2=va2", true),  //Valid multi key/val
				    new ResultPair("ke_1=va_1", true),	      //Valid key/val
				    new ResultPair("un1qu37r4cking", true),   //Valid tracking query
				    new ResultPair("key=val=key=val", false), //Invalid multi key/val
				    new ResultPair("key#val", false)	      //Invalid '#' is query end
				 };

};
