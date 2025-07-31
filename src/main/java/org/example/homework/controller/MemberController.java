package org.example.homework.controller;

import lombok.RequiredArgsConstructor;
import org.example.homework.dto.MemberRequest;
import org.example.homework.dto.MemberResponse;
import org.example.homework.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public MemberResponse createMember(
            @RequestBody MemberRequest memberRequest
    ) {
        return memberService.save(memberRequest);
    }

    @GetMapping("/members")
    public List<MemberResponse> getAllMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/members/{memberId]")
    public MemberResponse getMember(
            @PathVariable Long memberId
    ) {
        return memberService.getMember(memberId);
    }

    @PutMapping(("/members/{memberId]"))
    public MemberResponse updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberRequest memberRequest
    ){
        return memberService.updateMember(memberId, memberRequest);
    }

    @DeleteMapping(("/members/{memberId]"))
    public void deleteMember(
            @PathVariable Long memberId
    ){
        memberService.deleteMember(memberId);
    }
}
