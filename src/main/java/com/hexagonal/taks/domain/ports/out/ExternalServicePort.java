package com.hexagonal.taks.domain.ports.out;

import com.hexagonal.taks.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
