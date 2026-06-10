create user 'head' identified by 'manage123';
create user 'holder' identified by 'custom123';
create user 'executive' identified by 'exe123';

grant update, select on creditcard to 'executive';

show grants;

