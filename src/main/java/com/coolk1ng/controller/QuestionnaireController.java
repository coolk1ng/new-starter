package com.coolk1ng.controller;

import com.alibaba.fastjson.JSON;
import com.coolk1ng.pojo.dto.QuestionnaireDTO;
import com.coolk1ng.pojo.entity.Questionnaire;
import com.coolk1ng.service.QuestionnaireService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 问卷调查表(Questionnaire)表控制层
 *
 * @author coolk1ng
 * @since 2022-09-19 11:18:53
 */
@RestController
@RequestMapping(value = "/questionnaire")
public class QuestionnaireController {

    private final static Logger LOGGER = LoggerFactory.getLogger(QuestionnaireController.class);

    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping(value = "/getQuestionnaireList")
    public ResponseEntity<PageInfo<Questionnaire>> getQuestionnaireList(@RequestBody QuestionnaireDTO questionnaireDTO) {
        LOGGER.info("查询列表入参:{}", JSON.toJSONString(questionnaireDTO));
        return ResponseEntity.ok(questionnaireService.getQuestionnaireList(questionnaireDTO));
    }

    @PostMapping(value = "/saveAndUpdateQuestionnaire")
    public ResponseEntity<String> saveAndUpdateQuestionnaire(@RequestBody @Valid QuestionnaireDTO questionnaireDTO, BindingResult bindingResult) {
        //LOGGER.info("新增编辑入参:{}", JSON.toJSONString(questionnaireDTO));
       return ResponseEntity.ok(questionnaireService.saveAndUpdateQuestionnaire(questionnaireDTO));
    }

    @PostMapping(value = "deleteQuestionnaire")
    public ResponseEntity<String> deleteQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO) {
        LOGGER.info("删除的id:{}",JSON.toJSONString(questionnaireDTO.getId()));
        questionnaireService.deleteQuestionnaire(questionnaireDTO.getId());
        return ResponseEntity.ok("删除成功");
    }
}

