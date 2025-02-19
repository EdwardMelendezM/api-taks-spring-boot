package com.hexagonal.taks.domain.ports.in;

import com.hexagonal.taks.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
