:: # Copyright 2013, Big Switch Networks, Inc.
:: #
:: # LoxiGen is licensed under the Eclipse Public License, version 1.0 (EPL), with
:: # the following special exception:
:: #
:: # LOXI Exception
:: #
:: # As a special exception to the terms of the EPL, you may distribute libraries
:: # generated by LoxiGen (LoxiGen Libraries) under the terms of your choice, provided
:: # that copyright and licensing notices generated by LoxiGen are not altered or removed
:: # from the LoxiGen Libraries and the notice provided below is (i) included in
:: # the LoxiGen Libraries, if distributed in source code form and (ii) included in any
:: # documentation for the LoxiGen Libraries, if distributed in binary form.
:: #
:: # Notice: "Copyright 2013, Big Switch Networks, Inc. This library was generated by the LoxiGen Compiler."
:: #
:: # You may not use this file except in compliance with the EPL or LOXI Exception. You may obtain
:: # a copy of the EPL at:
:: #
:: # http://www.eclipse.org/legal/epl-v10.html
:: #
:: # Unless required by applicable law or agreed to in writing, software
:: # distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
:: # WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
:: # EPL for the specific language governing permissions and limitations
:: # under the EPL.

function read_scalar(reader, subtree, field_name, length)
    subtree:add(fields[field_name], reader.read(length))
end

function read_uint8_t(reader, version, subtree, field_name)
    read_scalar(reader, subtree, field_name, 1)
end

function read_uint16_t(reader, version, subtree, field_name)
    read_scalar(reader, subtree, field_name, 2)
end

function read_uint32_t(reader, version, subtree, field_name)
    read_scalar(reader, subtree, field_name, 4)
end

function read_uint64_t(reader, version, subtree, field_name)
    read_scalar(reader, subtree, field_name, 8)
end

function read_of_octets_t(reader, version, subtree, field_name)
    if not reader.is_empty() then
        subtree:add(fields[field_name], reader.read_all())
    end
end

function read_list_of_hello_elem_t(reader, version, subtree, field_name)
    -- TODO
end
