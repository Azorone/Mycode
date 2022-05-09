package sms.dao;

import sms.pojo.zl.material;

import java.util.List;
import java.util.Map;

public interface McDao {
   int addMc(Map<String,Object> map);
   int addm(material m);
   int delm(int zid);
   int delmc(int zid);
   List<material> getCidM( int cid);
   List<material> getTidM(int tid);
   material getm(int zid);
}
