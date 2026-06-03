import java.util.Arrays;

abstract class LoanRemote {
    abstract void applyLoan(int applicantId, String loanType);
    abstract void viewLoan(int applicantId);
    abstract void cancelLoan(int applicantId);

    public void log(String message) {
        System.out.println(message);
    }
}

class LoanService extends LoanRemote {
    private String[][] loans;

    public LoanService(int numApplicants, int maxLoansPerApplicant) {
        loans = new String[numApplicants][maxLoansPerApplicant];
    }

    @Override
    void applyLoan(int applicantId, String loanType) {
        if (applicantId >= 0 && applicantId < loans.length) {
            for (int i = 0; i < loans[applicantId].length; i++) {
                if (loans[applicantId][i] == null) {
                    loans[applicantId][i] = loanType;
                    log("Loan applied: " + loanType + " for applicant " + applicantId);
                    return; 
                }
            }
            log("Log: No available loan slots for applicant " + applicantId);
        }
    }

    @Override
    void viewLoan(int applicantId) {
        if (applicantId >= 0 && applicantId < loans.length) {
            System.out.println("Applicant " + applicantId + " loans: " + Arrays.toString(loans[applicantId]));
        }
    }

    @Override
    void cancelLoan(int applicantId) {
        if (applicantId >= 0 && applicantId < loans.length) {
            for (int i = 0; i < loans[applicantId].length; i++) {
                loans[applicantId][i] = null;
            }
            log("Loans cancelled for applicant " + applicantId);
        }
    }
}

public class LoanDemo {
    public static void main(String[] args) {
        LoanService service = new LoanService(2, 2);

        service.applyLoan(0, "Personal Loan");
        service.applyLoan(0, "Business Loan");
        service.applyLoan(1, "Education Loan");

        service.viewLoan(0);
        service.cancelLoan(0);
        service.viewLoan(0);
    }
}