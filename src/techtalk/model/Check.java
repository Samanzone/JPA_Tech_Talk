package techtalk.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: saman
 * Date: 8/9/13
 * Time: 1:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("CHECK")
public class Check extends Payment implements java.io.Serializable {

    @Column(name = "CHECK_NUMBER", length = 20)
    private String checkNumber;
    @Column(name = "BANK_NAME", length = 20)
    private String bankName;
    @Column(name = "BRANCH_NAME", length = 20)
    private String branchName;
    @Column(name = "CLEARD")
    private boolean cleared;

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }
}
