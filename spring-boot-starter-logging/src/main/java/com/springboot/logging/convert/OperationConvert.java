package com.springboot.logging.convert;


import com.springboot.logging.dto.OperationDetail;
import com.springboot.logging.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperationConvert {
    OperationConvert INSTANCE = Mappers.getMapper(OperationConvert.class);

    OperationDetail entityToDetail(Operation operation);

    List<OperationDetail> entityToDetail(List<Operation> operationList);
}
