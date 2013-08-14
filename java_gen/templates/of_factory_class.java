//:: # Copyright 2013, Big Switch Networks, Inc.
//:: #
//:: # LoxiGen is licensed under the Eclipse Public License, version 1.0 (EPL), with
//:: # the following special exception:
//:: #
//:: # LOXI Exception
//:: #
//:: # As a special exception to the terms of the EPL, you may distribute libraries
//:: # generated by LoxiGen (LoxiGen Libraries) under the terms of your choice, provided
//:: # that copyright and licensing notices generated by LoxiGen are not altered or removed
//:: # from the LoxiGen Libraries and the notice provided below is (i) included in
//:: # the LoxiGen Libraries, if distributed in source code form and (ii) included in any
//:: # documentation for the LoxiGen Libraries, if distributed in binary form.
//:: #
//:: # Notice: "Copyright 2013, Big Switch Networks, Inc. This library was generated by the LoxiGen Compiler."
//:: #
//:: # You may not use this file except in compliance with the EPL or LOXI Exception. You may obtain
//:: # a copy of the EPL at:
//:: #
//:: # http::: #www.eclipse.org/legal/epl-v10.html
//:: #
//:: # Unless required by applicable law or agreed to in writing, software
//:: # distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
//:: # WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
//:: # EPL for the specific language governing permissions and limitations
//:: # under the EPL.
//::
//:: import itertools
//:: import of_g
//:: include('_copyright.java')

//:: include('_autogen.java')

package ${factory.package};

//:: include("_imports.java")

public class ${factory.name} implements ${factory.interface.name} {
//:: for i in factory.interface.members:
    //:: if i.is_virtual:
    //::    continue
    //:: #endif

//::   if i.has_version(factory.version) and model.generate_class(i.versioned_class(factory.version)):
    public ${i.name}.Builder create${i.name[2:]}Builder() {
        return new ${i.versioned_class(factory.version).name}.Builder();
    }
//:: else:
    public ${i.name}.Builder create${i.name[2:]}Builder() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("${i.name} not supported in version ${factory.version}");
    }
//:: #endif
//:: #endfor

    //:: include("_singleton.java", msg=factory)
}