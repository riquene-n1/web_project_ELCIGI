package kr.ac.kopo.diet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.diet.vo.DietRecordVO;
import kr.ac.kopo.util.ConnectionFactory;

/**
 * JDBC implementation of DietDAO.
 */
public class DietDAOImpl implements DietDAO {

    @Override
    public void insertDiet(DietRecordVO diet) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into tbl_diet(id, member_id, diet_date, meal_type, food_name, calories, image_path, memo) ");
        sql.append("values(seq_tbl_diet_id.nextval, ?, ?, ?, ?, ?, ?, ?)");

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

            pstmt.setString(1, diet.getMemberId());
            pstmt.setString(2, diet.getDate().toString());
            pstmt.setString(3, diet.getMealType());
            pstmt.setString(4, diet.getFoodName());
            pstmt.setInt(5, diet.getCalories());
            pstmt.setString(6, diet.getImagePath());
            pstmt.setString(7, diet.getMemo());

            pstmt.executeUpdate();
        }
    }

    @Override
    public List<DietRecordVO> selectDietByMember(String memberId) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select id, member_id, diet_date, meal_type, food_name, calories, image_path, memo ");
        sql.append("  from tbl_diet where member_id = ? order by diet_date desc");

        List<DietRecordVO> list = new ArrayList<>();
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

            pstmt.setString(1, memberId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DietRecordVO record = new DietRecordVO();
                record.setId(rs.getInt("id"));
                record.setMemberId(rs.getString("member_id"));
                record.setDate(LocalDate.parse(rs.getString("diet_date")));
                record.setMealType(rs.getString("meal_type"));
                record.setFoodName(rs.getString("food_name"));
                record.setCalories(rs.getInt("calories"));
                record.setImagePath(rs.getString("image_path"));
                record.setMemo(rs.getString("memo"));
                list.add(record);
            }
        }
        return list;
    }

    @Override
    public List<DietRecordVO> selectDietByMemberAndDate(String memberId, LocalDate date) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("select id, member_id, diet_date, meal_type, food_name, calories, image_path, memo ");
        sql.append("  from tbl_diet where member_id = ? and diet_date = ? order by meal_type");

        List<DietRecordVO> list = new ArrayList<>();
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

            pstmt.setString(1, memberId);
            pstmt.setString(2, date.toString());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DietRecordVO record = new DietRecordVO();
                record.setId(rs.getInt("id"));
                record.setMemberId(rs.getString("member_id"));
                record.setDate(LocalDate.parse(rs.getString("diet_date")));
                record.setMealType(rs.getString("meal_type"));
                record.setFoodName(rs.getString("food_name"));
                record.setCalories(rs.getInt("calories"));
                record.setImagePath(rs.getString("image_path"));
                record.setMemo(rs.getString("memo"));
                list.add(record);
            }
        }
        return list;
    }

    @Override
    public void deleteDiet(int id) throws Exception {
        String sql = "delete from tbl_diet where id = ?";
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
