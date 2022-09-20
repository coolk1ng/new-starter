package com.coolk1ng.service;

import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.QuestionnaireDTO;
import com.coolk1ng.pojo.entity.Questionnaire;
import com.github.pagehelper.PageInfo;

/**
 * 问卷调查表(Questionnaire)表服务接口
 *
 * @author coolk1ng
 * @since 2022-09-19 11:18:54
 */
public interface QuestionnaireService {

    /**
     * 查询列表
     * @param questionnaireDTO
     * @return PageInfo<Questionnaire>
     */
    PageInfo<Questionnaire> getQuestionnaireList(QuestionnaireDTO questionnaireDTO);

    /**
     * 新增,编辑
     * @param questionnaireDTO
     * @return void
     */
    ResResult saveAndUpdateQuestionnaire(QuestionnaireDTO questionnaireDTO);

    /**
     * 删除
     * @param id
     * @return void
     */
    void deleteQuestionnaire(Integer id);
}
