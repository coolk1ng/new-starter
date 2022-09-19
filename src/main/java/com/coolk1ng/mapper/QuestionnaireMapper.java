package com.coolk1ng.mapper;

import com.coolk1ng.pojo.dto.QuestionnaireDTO;
import com.coolk1ng.pojo.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * QuestionnaireMapper
 *
 * @author coolk1ng
 * @since 2022-09-19
 */
@Mapper
public interface QuestionnaireMapper {

    /**
     * 查询列表
     * @param questionnaireDTO
     * @return List<Questionnaire>
     */
    List<Questionnaire> getQuestionnaireList(QuestionnaireDTO questionnaireDTO);

    /**
     * 新增
     * @param questionnaireDTO
     * @return void
     */
    void saveQuestionnaire(QuestionnaireDTO questionnaireDTO);

    /**
     * 编辑
     * @param questionnaireDTO
     * @return void
     */
    void updateQuestionnaire(QuestionnaireDTO questionnaireDTO);

    /**
     * 删除
     * @param id
     * @return void
     */
    void deleteQuestionnaire(Integer id);

    Questionnaire getQuestionnaireById(Integer id);
}
