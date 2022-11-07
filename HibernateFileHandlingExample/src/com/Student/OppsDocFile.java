package com.Student;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class OppsDocFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	private String sname;
	@Lob
	private byte[] sdata;

	private long size;

	private String uploadDate;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public byte[] getSdata() {
		return sdata;
	}

	public void setSdata(byte[] sdata) {
		this.sdata = sdata;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "StudentFile [sid=" + sid + ", sname=" + sname + ", sdata=" + Arrays.toString(sdata) + ", size=" + size
				+ ", uploadDate=" + uploadDate + "]";
	}

}
