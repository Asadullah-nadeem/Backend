Creating the Database Table
Create a table named crud inside your MySQL database using the following code.

               
                      CREATE TABLE `admin` (
                      `id` int(255) NOT NULL AUTO_INCREMENT,
                      `first_name` varchar(255) NOT NULL,
                      `last_name` varchar(255) NOT NULL,
                      `email` varchar(255) NOT NULL,
                      `gender` varchar(255) NOT NULL,
                      PRIMARY KEY (`id`)
                    )


Retrofit
                https://github.com/square/retrofit
                 https://square.github.io/
                 
                  /*retrofit */
                  implementation 'com.squareup.retrofit2:retrofit:2.9.0'
                  implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
                  
                  
swiperefreshlayout   

                   implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
