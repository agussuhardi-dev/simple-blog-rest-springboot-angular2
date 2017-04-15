CREATE TRIGGER `insert_article` AFTER INSERT ON `article`
FOR EACH ROW
  INSERT INTO history(id, date_insert, information_change, local_ip_change, new_article, new_title, old_article, old_title, public_ip_change, user_name_change, article_id, user_name, action)
              VALUES (NULL , now(), new.information_change, new.local_ip_change, new.article, new.title, '', '', new.public_ip_change, new.user_name_change, new.id, new.user_name, 'insert');




CREATE TRIGGER  update_article AFTER UPDATE ON `article`
FOR EACH ROW
  BEGIN

  IF (new.status='trash' OR new.delete_forever=1) THEN
    INSERT INTO history(id, date_insert, information_change, local_ip_change, new_article, new_title, old_article, old_title, public_ip_change, user_name_change, article_id, user_name, action)
    VALUES (NULL , now(), new.information_change, new.local_ip_change, new.article, '', '', old.title, new.public_ip_change, new.user_name_change, new.id, new.user_name, 'delete');

  ELSE
    INSERT INTO history(id, date_insert, information_change, local_ip_change, new_article, new_title, old_article, old_title, public_ip_change, user_name_change, article_id, user_name, action)
    VALUES (NULL , now(), new.information_change, new.local_ip_change, new.article, new.title, old.article, old.title, new.public_ip_change, new.user_name_change, new.id, new.user_name, 'update');

  END IF;

END

















CREATE TRIGGER insert_article AFTER INSERT ON article
  FOR EACH ROW
  INSERT INTO history(id, old_title, new_title, old_article, new_article, browser_change, host_name_change, information_change, local_ip_change, public_ip_change, operating_system_change, user_name_change, update_date, article_id)
                VALUES(NULL , NULL , new.title, NULL , new.article, new.browser_change, new.host_name_change, new.information_change, new.local_ip_change, new.public_ip_change, new.operating_system_change, new.user_name_change,now(), new.id)





CREATE TRIGGER update_article AFTER UPDATE ON article
  FOR EACH ROW
  INSERT INTO history(id, old_title, new_title, old_article, new_article, browser_change, host_name_change, information_change, local_ip_change, public_ip_change, operating_system_change, user_name_change, update_date, article_id)
                VALUES(NULL , old.title , new.title, old.article , new.article, new.browser_change, new.host_name_change, new.information_change, new.local_ip_change, new.public_ip_change, new.operating_system_change, new.user_name_change,now(), new.id)




