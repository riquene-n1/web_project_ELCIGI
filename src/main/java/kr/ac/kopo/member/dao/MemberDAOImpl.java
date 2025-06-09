package kr.ac.kopo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.util.ConnectionFactory;

public class MemberDAOImpl implements MemberDAO {

    @Override
    public MemberVO selectMemberByIDPassword(MemberVO loginVO) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select id, name, type, nickname, age, gender, height, weight ");
        sql.append("  from tbl_member ");
        sql.append(" where id = ? and password = ? ");

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

            pstmt.setString(1, loginVO.getId());
            pstmt.setString(2, loginVO.getPassword());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                MemberVO member = new MemberVO();
                member.setId(rs.getString("id"));
                member.setName(rs.getString("name"));
                member.setType(rs.getString("type"));
                member.setNickname(rs.getString("nickname"));
                member.setAge(rs.getInt("age"));
                member.setGender(rs.getString("gender"));
                member.setHeight(rs.getDouble("height"));
                member.setWeight(rs.getDouble("weight"));
                return member;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertMember(MemberVO member) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into tbl_member(id, password, name, type, nickname, age, gender, height, weight) ");
        sql.append("values(?, ?, ?, 'U', ?, ?, ?, ?, ?)");

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getNickname());
            pstmt.setInt(5, member.getAge());
            pstmt.setString(6, member.getGender());
            pstmt.setDouble(7, member.getHeight());
            pstmt.setDouble(8, member.getWeight());

            pstmt.executeUpdate();
        }
    }
}
