INSERT INTO public.items(
     name, parent_id, permission_group_id, type)
VALUES ( 'space', 0, 1, 0);

INSERT INTO public.items(
     name, parent_id, permission_group_id, type)
VALUES ( 'folder', 1, 122, 1);

INSERT INTO public.items(
     name, parent_id, permission_group_id, type)
VALUES ( 'file', 2, 252, 2);

INSERT INTO public.permission_groups(
    id, group_name)
VALUES (1, 'admin');

INSERT INTO public.permissions(
     group_id, permission_level, user_email)
VALUES ( 1, 0, 'ahmedraa@live.com');

INSERT INTO public.permissions(
     group_id, permission_level, user_email)
VALUES ( 1, 1, 'ahmad@gmail.com');

INSERT INTO public.permissions(
    group_id, permission_level, user_email)
VALUES ( 122, 1, 'ahmad@live.com');