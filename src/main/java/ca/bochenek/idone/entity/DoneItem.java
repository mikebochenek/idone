package ca.bochenek.idone.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(name = "item")
public class DoneItem implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Lob
	@Column(name = "donetext")
    private String text;

	@Column(name = "owner")
	private Long owner;

    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "donedate")
	private Date date;

    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdate")
	private Date createDate;

	@Column(name = "deleted")
    private boolean deleted;

	@Id
	private Long category;

	@Id
	private Long doneDay;

	
	public Long currentDay() {
		Calendar now = Calendar.getInstance();
		return toDay(now);
	}
	
	public Long toDay(Calendar c) {
		return 1L * c.get(Calendar.YEAR) * 1000 + c.get(Calendar.DAY_OF_YEAR);
	}
	

	public Long getDoneDay() {
		return doneDay;
	}

	public void setDoneDay(Long doneDay) {
		this.doneDay = doneDay;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
