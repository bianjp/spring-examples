CREATE TABLE post (
  id INTEGER AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE tag (
  id INTEGER AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE post_tag (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  post_id INTEGER NOT NULL,
  tag_id INTEGER NOT NULL
);
