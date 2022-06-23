package com.hospitalmanagement.Hospitalmanagement.repository;

import com.hospitalmanagement.Hospitalmanagement.entity.LeaveDetails;
import com.hospitalmanagement.Hospitalmanagement.view.LeaveView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LeaveRepository extends Repository<LeaveDetails,Integer> {

    LeaveDetails save(LeaveDetails leave);
    List<LeaveDetails> findByUserUserId(Integer leaveId);
    List<LeaveDetails> findAll();
     LeaveDetails findByLeaveIdAndApproval(Integer leaveId,byte approval);
    // @Query(value = "SELECT * FROM leave_details where user_id=?1 and leave_date=?2 and approval=?3",nativeQuery = true)
     LeaveDetails findByUserUserIdAndLeaveDateAndApproval(Integer userId, String date, byte approval);

}
