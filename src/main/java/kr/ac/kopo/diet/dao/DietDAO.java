package kr.ac.kopo.diet.dao;

import java.time.LocalDate;
import java.util.List;

import kr.ac.kopo.diet.vo.DietRecordVO;

/**
 * Data access interface for diet records.
 */
public interface DietDAO {

    void insertDiet(DietRecordVO diet) throws Exception;

    List<DietRecordVO> selectDietByMember(String memberId) throws Exception;

    List<DietRecordVO> selectDietByMemberAndDate(String memberId, LocalDate date) throws Exception;

    void deleteDiet(int id) throws Exception;
}
