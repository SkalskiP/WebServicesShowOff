package verification;

public class Identity {
    private boolean verificationStatus;
    private boolean admin;
    private String uid;

    public Identity(boolean verificationStatus, boolean isAdmin, String uid) {
        this.verificationStatus = verificationStatus;
        this.uid = uid;
        this.admin = isAdmin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(boolean verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
