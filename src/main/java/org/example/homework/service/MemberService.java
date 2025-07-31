package org.example.homework.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.homework.dto.MemberRequest;
import org.example.homework.dto.MemberResponse;
import org.example.homework.entity.Member;
import org.example.homework.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor //기본생성자가 아닌 생성자를 만들어줌

public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse save(MemberRequest memberRequest) {
        Member savedMember = memberRepository.save(new Member(memberRequest.getName()));
    }
}
