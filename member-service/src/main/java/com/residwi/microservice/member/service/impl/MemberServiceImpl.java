package com.residwi.microservice.member.service.impl;

import com.residwi.microservice.member.dto.MemberDto;
import com.residwi.microservice.member.handler.NotFoundException;
import com.residwi.microservice.member.entity.Member;
import com.residwi.microservice.member.repository.MemberRepository;
import com.residwi.microservice.member.request.CreateMemberRequest;
import com.residwi.microservice.member.request.UpdateMemberRequest;
import com.residwi.microservice.member.service.MemberService;
import com.residwi.microservice.member.service.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public MemberDto create(CreateMemberRequest createMemberRequest) {
        Member member = memberRepository.save(memberMapper.toEntity(createMemberRequest));
        return memberMapper.toDTO(member);
    }

    @Override
    public MemberDto update(Long userId, UpdateMemberRequest updateMemberRequest) {
        Member member = memberRepository.findByUserId(userId)
                .orElseThrow(NotFoundException::new);

        Member memberUpdated = memberRepository.save(memberMapper.toEntity(updateMemberRequest, member));
        return memberMapper.toDTO(memberUpdated);
    }

    @Override
    public MemberDto get(Long userId) {
        Member member = findMemberByUserIdOrThrowNotFound(userId);

        return memberMapper.toDTO(member);
    }

    @Override
    public List<MemberDto> list() {
        List<Member> members = memberRepository.findAll();

        return memberMapper.toDTOs(members);
    }

    private Member findMemberByUserIdOrThrowNotFound(Long userId) {
        return memberRepository.findByUserId(userId).orElseThrow(NotFoundException::new);
    }

}
