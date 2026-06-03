import java.util.logging.Logger;


public class DemoLogs {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger(DemoLogs.class.getName());
        String[] recruiters={"Google","Dlithe","cognizant","Accenture","zoho"};
        //KYC kyc = KYC.getKyc();
        //kyc.name="Razak";kyc.contact=876545677656L;
    }
}
    class KYC{
        String name;
        long contact;
        private static KYC kyc=new KYC();
        public static KYC getKyc(){
            return kyc;
        }
        private KYC(){}
    }

