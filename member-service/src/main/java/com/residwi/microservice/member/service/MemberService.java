package com.residwi.microservice.member.service;

import com.residwi.microservice.member.dto.MemberDto;
import com.residwi.microservice.member.request.CreateMemberRequest;
import com.residwi.microservice.member.request.UpdateMemberRequest;

import java.util.List;

public interface MemberService {

    MemberDto create(CreateMemberRequest createMemberRequest);

    MemberDto update(Long userId, UpdateMemberRequest updateMemberRequest);

    MemberDto get(Long userId);

    List<MemberDto> list();

}
