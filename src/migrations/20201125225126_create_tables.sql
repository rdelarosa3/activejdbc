CREATE TABLE users (

    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL UNIQUE,
    email VARCHAR(240) NOT NULL ,
    password VARCHAR(255) NOT NULL,
    avatar TEXT,
    role ENUM('member','admin','developer')NOT NULL DEFAULT 'member',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)

);

CREATE TABLE ads (

    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(240) NOT NULL,
    description TEXT         NOT NULL,
    price       DECIMAL(10,2),
    sold        BOOL,
    location    TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE categories (

    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(240) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE ad_categories (

    ad_id INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (ad_id) REFERENCES ads(id)
        ON DELETE CASCADE
);

CREATE TABLE images (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    url TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ad_images (
    ad_id INT UNSIGNED NOT NULL,
    image_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (image_id) REFERENCES images(id)
        ON DELETE CASCADE,
    FOREIGN KEY (ad_id) REFERENCES ads(id)
        ON DELETE CASCADE
);

SET FOREIGN_KEY_CHECKS=1;