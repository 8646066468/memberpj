package org.example.homework.repository;

import org.example.homework.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
