package org.example.homework.repository;

import org.example.homework.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Long> {
}
