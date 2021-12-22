package com.narp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.narp.model.MemberVO;

//@Mapper
public interface MemberMapper {

//	public List<MemberVO> memberList();
//	public int memberInsert(MemberVO vo);
//	public int memberDelete(int num);
//	public MemberVO memberContent(int num);
//	public int memberUpdate(MemberVO vo);

	@Select("select * from tbl_member")
	public List<MemberVO> memberList(); // -- SQL id="memberList"

	@Insert(" insert into tbl_member(num, id, pass, name, age, email, phone)\r\n"
			+ "        values(TBL_MEMBER_SEQ.NEXTVAL," + "        #{id},\r\n" + "        #{pass},\r\n"
			+ "        #{name},\r\n" + "        #{age},\r\n" + "        #{email},\r\n" + "        #{phone}\r\n"
			+ "        )")
	public int memberInsert(MemberVO vo);// -- SQL id="memberInsert"

	@Delete("delete from tbl_member where num=#{num}")
	public int memberDelete(int num);// -- SQL id="memberDelete"

	@Select("select * from tbl_member where num=#{num}")
	public MemberVO memberContent(int num);// -- SQL id="memberContent"

	@Update(" update tbl_member \r\n" + "         set age=#{age}, email=#{email}, phone=#{phone} \r\n"
			+ "         where num=#{num}")
	public int memberUpdate(MemberVO vo);// -- SQL id="memberUpdate"

}
