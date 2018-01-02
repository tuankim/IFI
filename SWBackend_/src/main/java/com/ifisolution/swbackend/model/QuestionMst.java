package com.ifisolution.swbackend.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * QuestionMst generated by hbm2java
 */
@Entity
@Table(name = "question_mst", catalog = "swbackend")
public class QuestionMst implements java.io.Serializable {

	private Integer questionId;
	private String questionContent;
	private Date createTime;
	private Date udpateTime;
	private String createBy;
	private String udpateBy;
	private Set<RequestMst> requestMsts = new HashSet<RequestMst>(0);
	private Integer questionParentId;
	private String listAnswer;
	private Set<AnswerMst> answerMsts = new HashSet<AnswerMst>(0);
	
	private List<QuestionMst> questionSub= new ArrayList<>();
	private List<String> anwers= new ArrayList<>();
	private List<String> answerContent= new ArrayList<>();
//	private Set<QuestionMst> questionSubMstsForQuestionId = new HashSet<QuestionMst>(0);

	public QuestionMst() {
	}

	public QuestionMst(String questionContent, Date createTime, Date udpateTime, String createBy, String udpateBy,
			Set<RequestMst> requestMsts, Integer questionParentId, Set<AnswerMst> answerMsts) {
		this.questionContent = questionContent;
		this.createTime = createTime;
		this.udpateTime = udpateTime;
		this.createBy = createBy;
		this.udpateBy = udpateBy;
		this.requestMsts = requestMsts;
		this.questionParentId = questionParentId;
		this.answerMsts = answerMsts;
//		this.questionSubMstsForQuestionId = questionSubMstsForQuestionId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "question_id", unique = true, nullable = false)
	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Column(name = "question_content", length = 45)
	public String getQuestionContent() {
		return this.questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "udpate_time", length = 10)
	public Date getUdpateTime() {
		return this.udpateTime;
	}

	public void setUdpateTime(Date udpateTime) {
		this.udpateTime = udpateTime;
	}

	@Column(name = "create_by", length = 45)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "udpate_by", length = 45)
	public String getUdpateBy() {
		return this.udpateBy;
	}

	public void setUdpateBy(String udpateBy) {
		this.udpateBy = udpateBy;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "questionMsts")
	@JsonIgnore
	public Set<RequestMst> getRequestMsts() {
		return this.requestMsts;
	}

	public void setRequestMsts(Set<RequestMst> requestMsts) {
		this.requestMsts = requestMsts;
	}

	@Column(name = "question_id_parent")
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "questionMstByQuestionId")
//	@JsonIgnore
	public Integer getQuestionParentId() {
		return this.questionParentId;
	}

	public void setQuestionParentId(Integer questionParentId) {
		this.questionParentId = questionParentId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionMst")
	public Set<AnswerMst> getAnswerMsts() {
		return this.answerMsts;
	}

	public void setAnswerMsts(Set<AnswerMst> answerMsts) {
		this.answerMsts = answerMsts;
	}

	@Transient
	public List<QuestionMst> getQuestionSub() {
		return questionSub;
	}

	
	public void setQuestionSub(List<QuestionMst> questionSub) {
		this.questionSub = questionSub;
	}
	
	@Transient
	public List<String> getAnwers() {
		return anwers;
	}

	public void setAnwers(List<String> anwers) {
		this.anwers = anwers;
	}

	@Column(name = "list_answer", length = 255)
	@JsonIgnore
	public String getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(String listAnswer) {
		this.listAnswer = listAnswer;
	}

	@Transient
	public List<String> getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(List<String> answerContent) {
		this.answerContent = answerContent;
	}
	
	
}