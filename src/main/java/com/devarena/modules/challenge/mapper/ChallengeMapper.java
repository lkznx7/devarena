package com.devarena.modules.challenge.mapper;
import com.devarena.modules.challenge.dto.request.ChallengeRequest;
import com.devarena.modules.challenge.dto.response.ChallengeResponse;
import com.devarena.modules.challenge.entity.Challenge;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {

    Challenge toChallenge(ChallengeRequest challengeRequest);
    ChallengeResponse toChallengeResponse(Challenge challenge);

}