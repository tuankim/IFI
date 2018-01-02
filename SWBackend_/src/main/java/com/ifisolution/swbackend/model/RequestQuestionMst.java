package com.ifisolution.swbackend.model;
// Generated Jan 2, 2018 6:00:06 PM by Hibernate Tools 5.2.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * RequestQuestionMst generated by hbm2java
 */
@Entity
@Table(name = "request_question_mst", catalog = "swbackend")
public class RequestQuestionMst implements java.io.Serializable {

	private RequestQuestionMstId id;
	private QuestionMst questionMst;
	private RequestMst requestMst;
	private String answerContent;

	public RequestQuestionMst() {
	}

	public RequestQuestionMst(RequestQuestionMstId id, QuestionMst questionMst, RequestMst requestMst,
			String answerContent) {
		this.id = id;
		this.questionMst = questionMst;
		this.requestMst = requestMst;
		this.answerContent = answerContent;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "requestId", column = @Column(name = "request_id", nullable = false)),
			@AttributeOverride(name = "questionId", column = @Column(name = "question_id", nullable = false)) })
	public RequestQuestionMstId getId() {
		return this.id;
	}

	public void setId(RequestQuestionMstId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	public QuestionMst getQuestionMst() {
		return this.questionMst;
	}

	public void setQuestionMst(QuestionMst questionMst) {
		this.questionMst = questionMst;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "request_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	public RequestMst getRequestMst() {
		return this.requestMst;
	}

	public void setRequestMst(RequestMst requestMst) {
		this.requestMst = requestMst;
	}

	@Column(name = "answer_content", nullable = false)
	public String getAnswerContent() {
		return this.answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

}