
export class Constants {
  private static BASE_HOSTNAME = "http://localhost";
  //private static BASE_HOSTNAME = "http://156.140.160.94";
  private static BASE_PORT = "4200";
  private static GATEWAY="gateway";
  private static BASE_URL = Constants.BASE_HOSTNAME + ':' + Constants.BASE_PORT+'/'+Constants.GATEWAY;
  private static SCANNER_PROCESSOR = "scannerprocessor";
  private static SCANNER_DATA = "scannerdata";

  static SCANNER_PROCESSOR_URL = Constants.BASE_URL + '/' + Constants.SCANNER_PROCESSOR;
  static SCANNER_DATA_URL = Constants.BASE_URL + '/' + Constants.SCANNER_DATA;
}
