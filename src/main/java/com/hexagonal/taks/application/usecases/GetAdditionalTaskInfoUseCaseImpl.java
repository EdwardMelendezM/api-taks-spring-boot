package com.hexagonal.taks.application.usecases;

import com.hexagonal.taks.domain.models.AdditionalTaskInfo;
import com.hexagonal.taks.domain.models.Task;
import com.hexagonal.taks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.taks.domain.ports.out.ExternalServicePort;
import com.hexagonal.taks.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }



    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return  externalServicePort.getAdditionalTaskInfo(id);
    }
}
