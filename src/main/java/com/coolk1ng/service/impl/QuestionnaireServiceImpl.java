package com.coolk1ng.service.impl;

import com.coolk1ng.base.ResResult;
import com.coolk1ng.mapper.QuestionnaireMapper;
import com.coolk1ng.pojo.dto.QuestionnaireDTO;
import com.coolk1ng.pojo.entity.Questionnaire;
import com.coolk1ng.service.QuestionnaireService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 问卷调查表(Questionnaire)表服务实现类
 *
 * @author makejava
 * @since 2022-09-19 11:18:54
 */
@Service("questionnaireService")
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public PageInfo<Questionnaire> getQuestionnaireList(QuestionnaireDTO questionnaireDTO) {
        PageHelper.startPage(questionnaireDTO.getPageNum() == null ? 1 : questionnaireDTO.getPageNum()
                , questionnaireDTO.getPageSize() == null ? 5 : questionnaireDTO.getPageSize());
        List<Questionnaire> questionnaireList = questionnaireMapper.getQuestionnaireList(questionnaireDTO);
        return new PageInfo<>(questionnaireList);
    }

    @Override
    @Transactional
    public ResResult saveAndUpdateQuestionnaire(QuestionnaireDTO questionnaireDTO) {
        Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{4,8}$");
        // 校验手机号
        if (!p.matcher(questionnaireDTO.getPhone()).matches()) {
            return ResResult.fail("手机号格式不正确");
        }
        if (questionnaireDTO.getId() == null) {
            // 新增
            questionnaireMapper.saveQuestionnaire(questionnaireDTO);
            return ResResult.success("新增成功");
        }
        // 编辑
        if (questionnaireMapper.getQuestionnaireById(questionnaireDTO.getId()) == null) {
            return ResResult.fail("不存在的记录");
        }
        questionnaireMapper.updateQuestionnaire(questionnaireDTO);
        return ResResult.success("编辑成功");
    }

    @Override
    @Transactional
    public void deleteQuestionnaire(Integer id) {
        questionnaireMapper.deleteQuestionnaire(id);
    }
}
