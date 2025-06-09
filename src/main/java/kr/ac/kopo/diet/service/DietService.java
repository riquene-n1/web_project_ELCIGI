package kr.ac.kopo.diet.service;

import java.time.LocalDate;
import java.util.List;

import kr.ac.kopo.diet.dao.DietDAO;
import kr.ac.kopo.diet.dao.DietDAOImpl;
import kr.ac.kopo.diet.vo.DietRecordVO;

/**
 * Application layer service for diet features.
 */
public class DietService {

    private DietDAO dietDao;

    public DietService() {
        this.dietDao = new DietDAOImpl();
    }

    public void addRecord(DietRecordVO record) throws Exception {
        dietDao.insertDiet(record);
    }

    public List<DietRecordVO> getRecords(String memberId) throws Exception {
        return dietDao.selectDietByMember(memberId);
    }

    public List<DietRecordVO> getRecords(String memberId, LocalDate date) throws Exception {
        return dietDao.selectDietByMemberAndDate(memberId, date);
    }

    public void removeRecord(int id) throws Exception {
        dietDao.deleteDiet(id);
    }
}
