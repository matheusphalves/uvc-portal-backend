package com.UVCLabs.uvcportalbackend.api.models.response;


import com.UVCLabs.uvcportalbackend.domain.ValidationGroups;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class StatusPostResponseDTO {

    @NotEmpty
    private Long statusPostId;

    @NotEmpty
    @Size(min = 2, max = 75)
    private String statusName;

    public StatusPostResponseDTO(Long statusPostId, String statusName) {
        this.statusPostId = statusPostId;
        this.statusName = statusName;
    }
}
