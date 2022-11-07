package PracticFile;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FilePractice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;

	private String fname;

	private String fileUploadDate;

	private long fsize;

	@Lob
	private byte[] bdata;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFileUploadDate() {
		return fileUploadDate;
	}

	public void setFileUploadDate(String fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	public byte[] getBdata() {
		return bdata;
	}

	public void setBdata(byte[] bdata) {
		this.bdata = bdata;
	}

	@Override
	public String toString() {
		return "FilePractice [fid=" + fid + ", fname=" + fname + ", fileUploadDate=" + fileUploadDate + ", fsize="
				+ fsize + ", bdata=" + Arrays.toString(bdata) + "]";
	}

}
