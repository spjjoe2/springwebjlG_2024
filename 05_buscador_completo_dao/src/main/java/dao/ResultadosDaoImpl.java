package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Resultado;

@Repository
public class ResultadosDaoImpl implements ResultadosDao {

	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Resultado> findByTematica(String tematica) {
		// TODO Auto-generated method stub
		String sql="select * from Resultados where tematica =?";
		RowMapper<Resultado> mapper = (r,f)->new Resultado(r.getString("url"),
															r.getString("tematica"),
															r.getString("descripcion"));
		return template.query(sql, mapper,tematica);
	 
	}

	@Override
	public void save(Resultado resultado) {
		String sql="insert into Resultados (url,tematica,descripcion) values (?,?,?)";
		template.update(sql,resultado.getUrl(),resultado.getTematica(),resultado.getDescripcion());

	}

	@Override
	public Resultado findByUrl(String url) {
		String sql="select * from Resultados where url =?";
		RowMapper<Resultado> mapper = (r,f)->new Resultado(r.getString("url"),
															r.getString("tematica"),
															r.getString("descripcion"));
		List<Resultado> resultados = template.query(sql,mapper,url);
		return resultados.size()>0?resultados.get(0):null;
	}

	@Override
	public void DeleteByUrl(String url) {
		template.update("delete from Resultados where url=?",url);

	}
	
	

}
