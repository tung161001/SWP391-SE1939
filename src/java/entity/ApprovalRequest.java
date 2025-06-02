/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Doan PC
 */
public class ApprovalRequest {

    private int id;
    private String requestType;
    private String approvalStatus;
    private String comments;

    // Constructors
    public ApprovalRequest(int id, String requestType, String approvalStatus, String comments) {
        this.id = id;
        this.requestType = requestType;
        this.approvalStatus = approvalStatus;
        this.comments = comments;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public String getComments() {
        return comments;
    }

    // Setters
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
