package org.example.homework.controller;

import lombok.RequiredArgsConstructor;
import org.example.homework.dto.MemberRequest;
import org.example.homework.dto.MemberResponse;
import org.example.homework.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public MemberResponse createMember( @RequestBody MemberRequest memberRequest){
            return memberService.save(memberRequest);
    }


}
