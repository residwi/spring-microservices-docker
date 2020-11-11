package com.residwi.microservice.member.service.mapper;

import com.residwi.microservice.member.dto.MemberDto;
import com.residwi.microservice.member.entity.Member;
import com.residwi.microservice.member.request.CreateMemberRequest;
import com.residwi.microservice.member.request.UpdateMemberRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberDto toDTO(Member member);

    List<MemberDto> toDTOs(List<Member> member);

    Member toEntity(CreateMemberRequest createMemberRequest);

    Member toEntity(UpdateMemberRequest updateMemberRequest, @MappingTarget Member member);
}
