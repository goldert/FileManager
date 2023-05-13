INSERT INTO public.items(
    id, name, parent_id, permission_group_id, type)
VALUES (1, 'space', 0, 1, 0);

INSERT INTO public.items(
    id, name, parent_id, permission_group_id, type)
VALUES (2, 'folder', 1, 122, 1);

INSERT INTO public.items(
    id, name, parent_id, permission_group_id, type)
VALUES (3, 'file', 2, 252, 2);

INSERT INTO public.permission_groups(
    id, group_name)
VALUES (1, 'admin');

INSERT INTO public.permissions(
    id, group_id, permission_level, user_email)
VALUES (1, 1, 0, 'ahmedraa@live.com');

INSERT INTO public.permissions(
    id, group_id, permission_level, user_email)
VALUES (2, 1, 1, 'ahmad@gmail.com');