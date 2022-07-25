package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value = "SELECT * FROM BOOKING WHERE ID_USER =:userId", nativeQuery = true)
    Optional<Booking> findByUserId(@Param("userId") Long userId);

}
