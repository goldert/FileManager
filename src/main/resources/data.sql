INSERT INTO public.items(
     name, parent_id, permission_group_id, type)
VALUES ( 'space', 0, 111, 0);

INSERT INTO public.items(
     name, parent_id, permission_group_id, type)
VALUES ( 'folder', 1, 112, 1);

INSERT INTO public.items(
     name, parent_id, permission_group_id, type)
VALUES ( 'file', 2, 113, 2);

INSERT INTO public.permission_groups(
    id, group_name)
VALUES (1, 'admin');

INSERT INTO public.permissions(
     group_id, permission_level, user_email)
VALUES ( 111, 0, 'ahmedraa@live.com');

INSERT INTO public.permissions(
     group_id, permission_level, user_email)
VALUES ( 111, 1, 'ahmad@gmail.com');

INSERT INTO public.permissions(
    group_id, permission_level, user_email)
VALUES ( 112, 1, 'ahmad@live.com');