package com.hospitalmanagement.Hospitalmanagement.entity;

import com.hospitalmanagement.Hospitalmanagement.form.LeaveForm;
import com.hospitalmanagement.Hospitalmanagement.view.LeaveView;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class LeaveDetails {



    public  static  enum Status{
        INACTIVE((byte)0),
        ACTIVE((byte)1);
        public final  byte value;
        private Status(byte value){
            this.value= value;
        }
    }

    public  static  enum Approval{
        INACTIVE((byte)0),
        ACTIVE((byte)1);
        public  final byte value;
        private Approval (byte value){
            this.value= value;
        }
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer leaveId;

    private String leaveDate;


    private Integer leaveType;


    private String reason;
    @ManyToOne
    private User user;
    @ManyToOne
    private Department department;

     private byte approval;


    private byte status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;


    public LeaveDetails(LeaveForm form){
    this.leaveDate= form.getLeaveDate();
    this.leaveType= form.getLeaveType();
    this.reason= form.getReason();
       this.user=new User(form.getUserId());
       this.department= new Department( form.getDepId());
        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
        this.status= Status.ACTIVE.value;
        this.approval= Approval.INACTIVE.value;
    }
    public  LeaveDetails(byte approval){
        this.approval=approval;
    }


}
