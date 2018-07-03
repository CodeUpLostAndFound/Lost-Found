
USE lostnfound_db;

INSERT INTO users (email, username, password) VALUES
  ('l.crowder@gmail.com', 'Lance', 'Logan'),
  ('guest@gmail.com', 'guest', 'password'),
  ('hma.485@icloud.com', 'Heather', 'Yamaly'),
  ('d.conner@gmail.com', 'Daniel', 'Password');



INSERT INTO categories (category) VALUES ('Electronics'),('Apparel'),('Personal Items'),('Pets'),('Miscellaneous');



INSERT INTO items (user_id, title, description, lost_or_found, img, address_1, address_2, city, state, zipcode) VALUES

 (1,'sunglasses', 'Found a pair of RayBan avaitors at the bar', FALSE ,NULL,'The Ticket Sports Pub','420 E Houston St', 'San Antonio', 'Texas', '78205'),
 (2, 'cellphone', 'I left my cellphone at the counter at this Starbucks', TRUE , NULL,'Starbucks', '411 E Quincy St', 'San Antonio', 'Texas', '78215'),
 (3,'Yorkie puppy', 'I  found a cute Yorkie puppy at the gas station', FALSE, NULL, 'Valero', '506 Austin Hwy', 'San Antonio', 'Texas', '78209'),
 (4,'dignity', 'I left my diginity here', FALSE, NULL, 'Codeup', '175 E Houston St', 'San Antonio', 'Texas', '78205');


INSERT INTO items_categories (items_id, categories_id) VALUES (1, 2), (2, 1),(3,4),(4,3),(4,5);
