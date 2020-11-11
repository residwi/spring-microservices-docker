package com.residwi.microservice.member.controller;

import com.residwi.microservice.member.dto.MemberDto;
import com.residwi.microservice.member.dto.ApiResponse;
import com.residwi.microservice.member.request.CreateMemberRequest;
import com.residwi.microservice.member.request.UpdateMemberRequest;
import com.residwi.microservice.member.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    @ApiOperation(value = "Get all members")
    public ResponseEntity<ApiResponse<List<MemberDto>>> getAll() {
        List<MemberDto> members = memberService.list();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        members
                ));
    }

    @PostMapping
    @ApiOperation(value = "Create new member")
    public ResponseEntity<ApiResponse<MemberDto>> createMember(@Valid @RequestBody CreateMemberRequest createMemberRequest) {
        MemberDto member = memberService.create(createMemberRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "CREATED",
                        member
                ));
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get member by userId")
    public ResponseEntity<ApiResponse<MemberDto>> getMemberByUserId(@PathVariable Long userId) {
        MemberDto member = memberService.get(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        member
                ));
    }

    @PutMapping("/{userId}")
    @ApiOperation(value = "Update member by userId  ")
    public ResponseEntity<ApiResponse<MemberDto>> updateMember(@PathVariable Long userId, @Valid @RequestBody UpdateMemberRequest updateMemberRequest) {
        MemberDto member = memberService.update(userId, updateMemberRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        member
                ));
    }
}
